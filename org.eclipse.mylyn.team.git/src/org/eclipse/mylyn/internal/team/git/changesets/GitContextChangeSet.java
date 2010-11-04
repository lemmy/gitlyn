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

import org.eclipse.mylyn.internal.team.ui.ContextChangeSet;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.team.ui.IContextChangeSet;
import org.eclipse.team.internal.core.subscribers.ActiveChangeSetManager;

/**
 * 
 */
@SuppressWarnings("restriction")
public class GitContextChangeSet extends ContextChangeSet implements
		IContextChangeSet {

	public GitContextChangeSet(ITask task, ActiveChangeSetManager manager) {
		super(task, manager);
	}
}
