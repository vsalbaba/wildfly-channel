/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.channel.version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.wildfly.channel.version.VersionMatcher.getLatestVersion;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class VersionMatcherTestCase {

    @Test
    public void test1() {
        assertLatestVersion("3",
                "1", "3", "2");
    }

    @Test
    public void test2() {
        assertLatestVersion("202109080827",
                "1", "202009080827", "202109080827");
    }

    @Test
    public void test3() {
        assertLatestVersion("1.1.4",
                "1.0.0", "1.0.2", "1.1.2", "1.1.4");
    }

    @Test
    public void test4() {
        assertLatestVersion("1.2",
                "1.0", "1.0.2", "1.1", "1.2");
    }

    @Test
    public void test5() {
        assertLatestVersion("Z",
                "A", "B", "C", "Z");
    }

    @Test
    public void test6() {
        assertLatestVersion("1.0.1.GA",
                "1.0.GA", "1.0.1.GA");
    }

    @Test
    public void test7() {
        assertLatestVersion("1.0.0.Beta",
                "1.0.0.Alpha", "1.0.0.Beta");
    }

    @Test
    public void test8() {
        assertLatestVersion("1:1",
                "0:1", "1:1");
    }

    @Test
    public void test9() {
        assertLatestVersion("2.1.9.redhat-1",
                "2.1.9.redhat-001", "2.1.9.redhat-1");
    }

    @Test
    public void test10() {
        assertLatestVersion("2.1.9.redhat-2",
                "2.1.9.redhat-001", "2.1.9.redhat-2");
    }

    @Test
    public void test11() {
        assertLatestVersion("2.1.9.redhat-002",
                "2.1.9.redhat-1", "2.1.9.redhat-002");
    }
    @Test
    public void test12() {
        assertLatestVersion("1.0.0.Final",
                "1.0.0", "1.0.0.Final");
    }

    @Test
    public void test13() {
        assertLatestVersion("1.0.0.Final",
                "1.0.0.Alpha", "1.0.0.Final");
    }

    @Test
    public void test14() {
        assertLatestVersion("1.0.0.GA-redhat-1",
                "1.0.0.redhat-1", "1.0.0.GA-redhat-1");
    }

    @Test
    public void test15() {
        assertLatestVersion("1.0.10",
                "1.0.2", "1.0.10");
    }

    @Test
    public void test16() {
        assertLatestVersion("1.0.0.GA",
                "1.0.0.GA", "1.0.0.CR1");
    }

    @Test
    public void test17() {
        assertLatestVersion("2.1.9.redhat-010",
                "2.1.9.redhat-010", "2.1.9.redhat-002");
    }

    private static void assertLatestVersion(String expectedLatest, String... versions) {
        assertEquals(expectedLatest, getLatestVersion(Set.of(versions)).get());
    }
}
