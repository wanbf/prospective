package com.angel.prospective.dubbo.client;

import java.io.Serializable;

/**
 * @author wanbf
 * @date 2019/2/21 10:19
 */
public enum EnvTag implements Serializable {
    LVMAMA(0), TEST_ENV(1), PROD_ENV(2), TEST_UNALLOCATED(3), PROD_UNALLOCATED(4),
    ARK_FREE(5), THURSDAY_FREE(6), SIMULATION_FREE(7), PROD_FREE(8), TEST_FREE(9);

    private int code;

    EnvTag(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
