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

package org.eclipse.mylyn.internal.team.git.changesets;

import org.eclipse.egit.core.Activator;
import org.eclipse.egit.ui.ICommitDialogProposal;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.team.ui.AbstractActiveChangeSetProvider;
import org.eclipse.mylyn.team.ui.IContextChangeSet;
import org.eclipse.team.internal.core.subscribers.ActiveChangeSetManager;

@SuppressWarnings("restriction")
public class GitActiveChangeSetProvider extends AbstractActiveChangeSetProvider {

	private ActiveChangeSetManager instance;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.mylyn.team.ui.AbstractActiveChangeSetProvider#
	 * getActiveChangeSetManager()
	 */
	@Override
	public synchronized ActiveChangeSetManager getActiveChangeSetManager() {
		if (instance == null) {
			instance = new GitActiveChangeSetManager();
			Activator
					.getDefault()
					.getBundle()
					.getBundleContext()
					.registerService(ICommitDialogProposal.class.getName(),
							instance, null);
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.mylyn.team.ui.AbstractActiveChangeSetProvider#createChangeSet
	 * (org.eclipse.mylyn.tasks.core.ITask)
	 */
	@Override
	public IContextChangeSet createChangeSet(ITask task) {
		return new GitContextChangeSet(task, getActiveChangeSetManager());
	}
}
