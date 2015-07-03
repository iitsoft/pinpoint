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

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.util.List;

/**
 * @author emeroad
 */
public class JAXBContextTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final JAXBContext jaxbContext = initContext();

    private static JAXBContext initContext() {
        try {
            return JAXBContext.newInstance(Plugin.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    public void test() throws JAXBException {

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        URL resource = getResource();
        Plugin unmarshal = (Plugin) unmarshaller.unmarshal(resource);
        logger.debug("{}", unmarshal.getId());
        logger.debug("{}", unmarshal.getTransform());
        List<Transform> transform = unmarshal.getTransform();
        for (Transform transform1 : transform) {
            logger.debug("{}", transform1.getScope());

            List<Clazz> clazzList = transform1.getClazzList();
            for (Clazz clazz : clazzList) {
                logger.debug("clazz name={}", clazz.getName());
            }

        }

//        System.out.println(unmarshal.get));
    }

    private URL getResource() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader.getResource("plugin-gson-sample.xml");
    }
}
