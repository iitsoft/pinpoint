/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.bootstrap.plugin.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author emeroad
 */
public class Transform {
    private String scope;

    @XmlElement(name="class")
    private List<Clazz> clazzList = new ArrayList<Clazz>();

    public String getScope() {
        return scope;
    }

    @XmlAttribute
    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<Clazz> getClazzList() {
        return clazzList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transform{");
        sb.append("scope='").append(scope).append('\'');
        sb.append(", clazzList=").append(clazzList);
        sb.append('}');
        return sb.toString();
    }
}
