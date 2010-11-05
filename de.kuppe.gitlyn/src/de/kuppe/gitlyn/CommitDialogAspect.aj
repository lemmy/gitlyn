/*******************************************************************************
 * Copyright (c) 2010 Markus Alexander Kuppe and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Markus Alexander Kuppe <egit@lemmster.de> - initial API and implementation
 *******************************************************************************/
package de.kuppe.gitlyn;

import org.eclipse.egit.ui.internal.dialogs.CommitDialog;
import org.eclipse.mylyn.internal.team.ui.FocusedTeamUiPlugin;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.ITaskActivityManager;
import org.eclipse.mylyn.tasks.ui.TasksUi;

@SuppressWarnings("restriction")
public aspect CommitDialogAspect {
	/**
	 * Inject the commit message into the member prior to
	 * org.eclipse.egit.ui.internal
	 * .dialogs.CommitDialog.createDialogArea(Composite) invocation
	 */
	pointcut getCommitMessage(CommitDialog commitDialog) : 
		this(commitDialog) 
		&& within(CommitDialog) 
		&& get(private String CommitDialog.commitMessage);

	before(CommitDialog cd): getCommitMessage(cd) {
		cd.setCommitMessage(getCommitMessageFromCurrentTask());
	}

	/**
	 * @return The emptry String or a commit message from the current active
	 *         task
	 */
	private static String getCommitMessageFromCurrentTask() {
		try {
			// get active task
			ITaskActivityManager tam = TasksUi.getTaskActivityManager();
			ITask task = tam.getActiveTask();
			if(task == null)
				return "";

			// get the commit dialog template
			String template = FocusedTeamUiPlugin.getDefault().getPreferenceStore().getString(
						FocusedTeamUiPlugin.COMMIT_TEMPLATE);
			return FocusedTeamUiPlugin.getDefault().getCommitTemplateManager().generateComment(task, template);
		} catch(Exception e) {
			return "";
		}
	}
}
