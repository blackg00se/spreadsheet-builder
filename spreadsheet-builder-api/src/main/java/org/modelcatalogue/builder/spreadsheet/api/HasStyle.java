package org.modelcatalogue.builder.spreadsheet.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public interface HasStyle {

    /**
     * Applies a customized named style to the current element.
     *
     * @param name the name of the style
     * @param styleDefinition the definition of the style customizing the predefined style
     */
    void style(String name, @DelegatesTo(CellStyle.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.builder.spreadsheet.api.CellStyle") Closure styleDefinition);

    /**
     * Applies the style defined by the closure to the current element.
     * @param styleDefinition the definition of the style
     */
    void style(@DelegatesTo(CellStyle.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.builder.spreadsheet.api.CellStyle") Closure styleDefinition);

    /**
     * Applies the names style to the current element.
     *
     * The style can be changed no longer.
     *
     * @param name the name of the style
     */
    void style(String name);
}
