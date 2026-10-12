/*
 * Copyright (C) 2026 IDRsolutions
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
 *
 */
package com.idrsolutions.examples;

import org.jpedal.examples.viewer.Viewer;

import javax.swing.SwingUtilities;

public class OpenViewer {

    public static void main(final String[] args) {

        // The Viewer class is a complete Swing PDF Viewer which can
        // be launched as a standalone application in its own window.

        // Swing components should always be created and used on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            // Initialize a new instance of the Viewer
            final Viewer viewer = new Viewer();

            // Create the user interface and display the Viewer window
            viewer.setupViewer();

            // Open a PDF file in the Viewer
            // A URL to a PDF file can also be used
            viewer.openDefaultFile("inputFile.pdf");
        });

    }

}
