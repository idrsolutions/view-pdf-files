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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class EmbedViewer {

    public static void main(final String[] args) {

        // The Viewer can be added to any Swing container, allowing it
        // to be embedded inside your own application.

        // Swing components should always be created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            // Create your own window to hold the Viewer
            final JFrame frame = new JFrame("Embedded JPedal Viewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);

            // The container the Viewer will be added to
            final JPanel viewerPanel = new JPanel();
            frame.add(viewerPanel);

            // Initialize a new instance of the Viewer inside the container
            // The second argument is the path to a preferences file, or null to use the defaults
            final Viewer viewer = new Viewer(viewerPanel, null);

            // Create the user interface inside the container
            viewer.setupViewer();

            frame.setVisible(true);

            // Open a PDF file in the Viewer
            viewer.openDefaultFile("inputFile.pdf");
        });

    }

}
