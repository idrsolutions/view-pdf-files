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
import org.jpedal.examples.viewer.ViewerCommands;
import org.jpedal.examples.viewer.ViewerValues;

import javax.swing.SwingUtilities;

public class ControlViewer {

    public static void main(final String[] args) {

        // The Viewer can be controlled from your own code using commands,
        // performing the same actions a user could from the toolbar and menus.

        // Swing components should always be created and used on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            // Initialize a new instance of the Viewer and display it
            final Viewer viewer = new Viewer();
            viewer.setupViewer();

            // Open a PDF file in the Viewer
            viewer.openDefaultFile("inputFile.pdf");

            // Read values from the Viewer, such as the number of pages in the open file
            final int pageCount = (int) viewer.getViewerValue(ViewerValues.PAGECOUNT);
            System.out.println("Page count: " + pageCount);

            // Command arguments are passed as Strings
            // PDF page indices start from one, not zero!
            if (pageCount >= 2) {
                // Go to the second page
                viewer.executeCommand(ViewerCommands.GOTO, "2");
            }

            // Set the zoom to 150%
            // Named modes such as "Fit Width" can also be used
            viewer.executeCommand(ViewerCommands.SCALING, "150");

            // Rotate the page display by 90 degrees
            viewer.executeCommand(ViewerCommands.ROTATION, "90");
        });

    }

}
