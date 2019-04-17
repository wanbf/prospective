package com.angel.prospective.dubbo.client;

import java.util.List;

/**
 * @author wanbf
 * @date 2019/2/26 10:02
 */
public interface VmService {
    List<VmInfo> getVmInfoByEnv(EnvTag env);
}
