package com.example.aurelian.cleanerapp;

import java.text.DecimalFormat;

/**
 * Created by Aurelian on 3/20/2017.
 */

public class Converter {
    public static String floatForm (double d)
    {
        return new DecimalFormat("#.##").format(d);
    }

    public static String bytesToHuman (long size , boolean withUnit)
    {
        long Kb = 1  * 1024;
        long Mb = Kb * 1024;
        long Gb = Mb * 1024;
        long Tb = Gb * 1024;
        long Pb = Tb * 1024;
        long Eb = Pb * 1024;

        if (size <  Kb)                 return floatForm(        size     ) + (withUnit?" byte":"");
        if (size >= Kb && size < Mb)    return floatForm((double)size / Kb) + (withUnit?"KB":"");
        if (size >= Mb && size < Gb)    return floatForm((double)size / Mb) + (withUnit?"MB":"");
        if (size >= Gb && size < Tb)    return floatForm((double)size / Gb) + (withUnit?"GB":"");
        if (size >= Tb && size < Pb)    return floatForm((double)size / Tb) + (withUnit?"TB":"");
        if (size >= Pb && size < Eb)    return floatForm((double)size / Pb) + (withUnit?"PB":"");
        if (size >= Eb)                 return floatForm((double)size / Eb) + (withUnit?"EB":"");

        return "???";
    }
}
