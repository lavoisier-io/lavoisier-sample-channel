/*
 * Copyright (C) 2016 Lavoisier.io
 *
 * This file is part of the Lavoisier.io project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.lavoisier.channel.sample;

import io.lavoisier.api.Channel;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;

import java.util.Properties;

public class SampleChannelActivator implements BundleActivator {

    private ServiceRegistration serviceRegistration;

    public void start(BundleContext context) throws Exception {
        ServiceReference ref = context.getServiceReference(LogService.class.getName());
        if (ref != null) {
            LogService logService = (LogService) context.getService(ref);
            logService.log(LogService.LOG_INFO, "SampleChannelActivator");
            Properties props = new Properties();
            props.put("id", "io.lavoisier.channel.sample");
            serviceRegistration = context.registerService(Channel.class.getName(), new SampleChannel(logService), props);
        }
    }

    public void stop(BundleContext bundleContext) throws Exception {
        if(serviceRegistration != null) {
            serviceRegistration.unregister();
        }
    }
}
