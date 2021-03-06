package org.modelcatalogue.builder.spreadsheet.poi

import groovy.transform.PackageScope
import org.apache.poi.common.usermodel.Hyperlink
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFHyperlink
import org.apache.poi.xssf.usermodel.XSSFName
import org.apache.poi.xssf.usermodel.XSSFWorkbook

@PackageScope class PendingLink implements Resolvable {

    final XSSFCell cell
    final String name

    PendingLink(XSSFCell cell, String name) {
        this.cell = cell
        this.name = name
    }

    void resolve() {
        XSSFWorkbook workbook = cell.row.sheet.workbook as XSSFWorkbook
        XSSFName xssfName = workbook.getName(PoiCell.fixName(name)) as XSSFName

        if (!xssfName) {
            throw new IllegalArgumentException("Name $name does not exist! Please consider that the name was normalized to ${PoiCell.fixName(name)}")
        }

        XSSFHyperlink link = workbook.creationHelper.createHyperlink(Hyperlink.LINK_DOCUMENT) as XSSFHyperlink
        link.address = xssfName.refersToFormula

        cell.hyperlink = link
    }
}
