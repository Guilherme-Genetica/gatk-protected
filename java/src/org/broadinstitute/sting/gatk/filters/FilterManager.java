/*
 * Copyright (c) 2010 The Broad Institute
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the �Software�), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED �AS IS�, WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.broadinstitute.sting.gatk.filters;

import org.apache.log4j.Logger;
import org.broadinstitute.sting.utils.classloader.PluginManager;

import net.sf.picard.filter.SamRecordFilter;

/**
 * Manage filters and filter options.  Any requests for basic filtering classes
 * should ultimately be made through this class.
 *
 * @author mhanna
 * @version 0.1
 */
public class FilterManager extends PluginManager<SamRecordFilter> {
    /**
     * our log, which we want to capture anything from this class
     */
    private static Logger logger = Logger.getLogger(FilterManager.class);

    public FilterManager() {
        super(SamRecordFilter.class,"filter","Filter");
    }

    /**
     * Instantiate a filter of the given type.  Along the way, scream bloody murder if
     * the filter is not available.
     * @param filterType
     * @return
     */
    public SamRecordFilter createFilterByType(Class<? extends SamRecordFilter> filterType) {
        return this.createByName(getName(filterType));
    }
}
