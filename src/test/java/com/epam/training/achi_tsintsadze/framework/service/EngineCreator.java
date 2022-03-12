package com.epam.training.achi_tsintsadze.framework.service;

import com.epam.training.achi_tsintsadze.framework.models.Engine;

public class EngineCreator {
    private static final String TESTDATA_INSTANCES = "testdata.instances";
    private static final String TESTDATA_SYSTEM = "testdata.system";
    private static final String TESTDATA_SERIES = "testdata.series";
    private static final String TESTDATA_MACHINE = "testdata.machine";
    private static final String TESTDATA_GPU = "testdata.gpu";
    private static final String TESTDATA_GPUNUMBER = "testdata.gpuNumber";
    private static final String TESTDATA_SSD = "testdata.ssd";
    private static final String TESTDATA_LOCATION = "testdata.location";
    private static final String TESTDATA_USAGE = "testdata.usage";

    public static Engine withSpecsFromProperty() {
        return new Engine(TestDataReader.getTestData(TESTDATA_INSTANCES),
                TestDataReader.getTestData(TESTDATA_SYSTEM),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE),
                TestDataReader.getTestData(TESTDATA_GPU),
                TestDataReader.getTestData(TESTDATA_GPUNUMBER),
                TestDataReader.getTestData(TESTDATA_SSD),
                TestDataReader.getTestData(TESTDATA_LOCATION),
                TestDataReader.getTestData(TESTDATA_USAGE));
    }
}
