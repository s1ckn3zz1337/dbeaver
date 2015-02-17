/*
 * Copyright (C) 2010-2014 Serge Rieder
 * serge@jkiss.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.jkiss.dbeaver.ext.test.ui;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.jkiss.dbeaver.ui.DBIcon;
import org.jkiss.dbeaver.ui.controls.folders.FolderComposite;
import org.jkiss.dbeaver.ui.controls.folders.FolderDescription;
import org.jkiss.dbeaver.ui.controls.folders.IFolderDescription;

public class TestDialog extends TrayDialog {

    private FolderComposite folderComposite;
    private final IFolderDescription[] tabs;

    public TestDialog(Shell shell)
    {
        super(shell);

        tabs = new IFolderDescription[3];
        tabs[0] = new FolderDescription("tab1", "Tab 1", DBIcon.TREE_TABLE.getImage(), "Tooltip 1") {
            @Override
            public Composite createControl(Composite parent) {
                return null;
            }
        };
        tabs[1] = new FolderDescription("tab2", "Tab with long-long name", DBIcon.TREE_COLUMNS.getImage(), "Tooltip 2") {

            @Override
            public Composite createControl(Composite parent) {
                return null;
            }
        };
        tabs[2] = new FolderDescription("tab3", "Example", DBIcon.PROJECT.getImage(), "123123") {

            @Override
            public Composite createControl(Composite parent) {
                return null;
            }
        };
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    @Override
    protected Control createDialogArea(Composite parent)
    {
        getShell().setText("Test");
        Composite group = (Composite) super.createDialogArea(parent);
        GridData gd = new GridData(GridData.FILL_BOTH);
        group.setLayoutData(gd);

        folderComposite = new FolderComposite(group, SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 300;
        gd.heightHint = 300;
        folderComposite.setLayoutData(gd);
        folderComposite.setFolders(tabs);

        return group;
    }

}
