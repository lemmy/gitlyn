/*******************************************************************************
 * Copyright (c) 2010 Chris Aniszczyk and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Chris Aniszczyk <caniszczyk@gmail.com> - initial API and implementation
 *     Markus Alexander Kuppe <egit@lemmster.de>
 *******************************************************************************/
package org.eclipse.mylyn.internal.team.git.tasks;

import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.ITaskActivationListener;

public class TaskActivationListener implements ITaskActivationListener {

	/* (non-Javadoc)
	 * @see org.eclipse.mylyn.tasks.core.ITaskActivationListener#preTaskActivated(org.eclipse.mylyn.tasks.core.ITask)
	 */
	public void preTaskActivated(ITask task) {
		//nop
	}

	/* (non-Javadoc)
	 * @see org.eclipse.mylyn.tasks.core.ITaskActivationListener#preTaskDeactivated(org.eclipse.mylyn.tasks.core.ITask)
	 */
	public void preTaskDeactivated(ITask task) {
		//nop
	}

	/* (non-Javadoc)
	 * @see org.eclipse.mylyn.tasks.core.ITaskActivationListener#taskActivated(org.eclipse.mylyn.tasks.core.ITask)
	 */
	public void taskActivated(ITask task) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.mylyn.tasks.core.ITaskActivationListener#taskDeactivated(org.eclipse.mylyn.tasks.core.ITask)
	 */
	public void taskDeactivated(ITask task) {
		//nop
	}
}
