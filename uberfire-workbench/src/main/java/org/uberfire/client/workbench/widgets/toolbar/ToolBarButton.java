/*
 * Copyright 2012 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.uberfire.client.workbench.widgets.toolbar;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.Image;

/**
 * A button in the ToolBar.
 */
public class ToolBarButton extends CustomButton {

    private static final String STYLE_NAME = "toolBarButton";

    public ToolBarButton( final ImageResource image ) {
        this( new Image( image ) );
    }

    public ToolBarButton( final Image image ) {
        super( image );
        setStyleName( STYLE_NAME );
    }

}
