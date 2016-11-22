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

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.osgi.service.log.LogService;

import io.lavoisier.channel.api.*;


public class SampleChannel implements Channel {

    private final LogService logService;

    public SampleChannel(LogService logService) {
        this.logService = logService;
    }

    @Override
    public InputStream getDescriptor() {
        return getClass().getClassLoader().getResourceAsStream("channel.xml");
    }

    @Override
    public Map<String, Spark> getSparks() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Condition> getConditions() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Fuel> getFuels() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Action> getActions() {
        return Collections.emptyMap();
    }
}
