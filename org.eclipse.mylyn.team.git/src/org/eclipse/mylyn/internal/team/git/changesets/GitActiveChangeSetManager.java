/*******************************************************************************
 * Copyright (c) 2010 Markus Alexander Kuppe and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Markus Alexander Kuppe <egit@lemmster.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.internal.team.git.changesets;

import java.util.Date;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egit.ui.ICommitDialogProposal;
import org.eclipse.team.core.diff.IDiff;
import org.eclipse.team.internal.core.subscribers.ActiveChangeSetManager;
import org.eclipse.team.internal.core.subscribers.ChangeSet;

@SuppressWarnings("restriction")
public class GitActiveChangeSetManager extends ActiveChangeSetManager implements ICommitDialogProposal {

	/* (non-Javadoc)
	 * @see org.eclipse.team.internal.core.subscribers.ActiveChangeSetManager#getDiff(org.eclipse.core.resources.IResource)
	 */
	@Override
	public IDiff getDiff(IResource resource) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.team.internal.core.subscribers.ActiveChangeSetManager#getName()
	 */
	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return ""; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.team.internal.core.subscribers.ChangeSetManager#initializeSets()
	 */
	@Override
	protected void initializeSets() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.egit.ui.ICommitDialogProposal#getMessage()
	 */
	public String getMessage() {
		final ChangeSet[] changeSets = getSets();
		for (int i = 0; i < changeSets.length;) {
			final ChangeSet changeSet = changeSets[i++];
			return changeSet.getComment();
		}
		return ""; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.egit.ui.ICommitDialogProposal#getAuthor()
	 */
	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.egit.ui.ICommitDialogProposal#getCommitter()
	 */
	public String getCommitter() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.egit.ui.ICommitDialogProposal#getDate()
	 */
	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
