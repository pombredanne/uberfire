/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.backend.vfs;

import java.util.HashMap;
import java.util.Map;

import org.jboss.errai.common.client.api.annotations.Portable;

public final class PathFactory {

    private PathFactory() {
    }

    public static Path newPath( final String uri ) {
        return new PathImpl( uri );
    }

    public static Path newPath( final String fileName,
                                final String uri ) {
        return new PathImpl( fileName, uri );
    }

    public static Path newPath( final String fileName,
                                final String uri,
                                final Map<String, Object> attrs ) {
        return new PathImpl( fileName, uri, attrs );
    }

    @Portable
    public static class PathImpl implements Path {

        private String                  uri        = null;
        private String                  fileName   = null;
        private HashMap<String, Object> attributes = null;

        public PathImpl() {
        }

        private PathImpl( final String uri ) {
            this( null, uri, null );
        }

        private PathImpl( final String fileName,
                          final String uri ) {
            this( fileName, uri, null );
        }

        private PathImpl( final String fileName,
                          final String uri,
                          final Map<String, Object> attrs ) {
            this.fileName = fileName;
            this.uri = uri;
            if ( attrs == null ) {
                this.attributes = new HashMap<String, Object>();
            } else {
                this.attributes = new HashMap<String, Object>( attrs );
            }
        }

        @Override
        public String getFileName() {
            return fileName;
        }

        @Override
        public String toURI() {
            return uri;
        }

        public Map<String, Object> getAttributes() {
            return attributes;
        }

        @Override
        public int compareTo( Path another ) {
            return this.fileName.compareTo( another.getFileName() );
        }

        @Override
        public boolean equals( final Object o ) {

            if ( o == null ) {
                return false;
            }

            if ( o instanceof Path ) {
                return this.fileName.equals( ( (PathImpl) o ).getFileName() );
            }

            return false;
        }

        @Override
        public int hashCode() {
            return this.fileName.hashCode();
        }

        @Override
        public String toString() {
            return "PathImpl{" +
                    "uri='" + uri + '\'' +
                    ", fileName='" + fileName + '\'' +
                    ", attrs=" + attributes +
                    '}';
        }
    }

}
