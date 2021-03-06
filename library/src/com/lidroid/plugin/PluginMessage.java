/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lidroid.plugin;

/**
 * Created with IntelliJ IDEA.
 * User: wyouflf
 * Date: 13-6-17
 * Time: AM 11:53
 */
public class PluginMessage {

    private static long seed = 0;
    public long seq;
    public final int cmd;
    public final String content;
    public final Object[] args;


    public PluginMessage(int cmd, String content, Object... args) {
        this.cmd = cmd;
        this.content = content;
        this.args = args;
        seq = seed++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PluginMessage that = (PluginMessage) o;

        if (seq != that.seq) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (seq ^ (seq >>> 32));
    }
}
