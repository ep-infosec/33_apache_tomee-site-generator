/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tomee.website.audit;

import org.apache.openejb.loader.IO;
import org.tomitribe.tio.Dir;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Jbake header in asciidoc form cannot have a space
 * after the title.
 */
public class JbakeHeaderHasNoSpace {

    public static void main(String[] args) throws IOException {
        final Dir dir = Dir.from(new File("/Users/dblevins/work/apache/tomee-site-generator/repos/master"));
        final List<File> files = dir.searchFiles()
                .filter(file -> file.getName().endsWith(".adoc"))
                .collect(Collectors.toList());
        for (final File file : files) {
            final String contents = IO.slurp(file);
            final String[] lines = contents.split("\n");
            if ("".equals(lines[1])) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
