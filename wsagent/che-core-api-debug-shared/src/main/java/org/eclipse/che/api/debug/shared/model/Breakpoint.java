/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.api.debug.shared.model;

/** @author Anatoliy Bazko */
public interface Breakpoint {
  /** The location of the breakpoint. */
  Location getLocation();

  /** Indicates if it is enabled or not. */
  boolean isEnabled();

  /** The condition. */
  String getCondition();

  void setCondition(String condition);

  /**
   * Number of activations for breakpoint. If is set to 0 then breakpoint can be activated an
   * infinite number of times. If is set to -1 then breakpoint can be activated only by {@link
   * RunToLocationAction}, but breakpoint will be deleted after {@link ResumeAction}.
   */
  int getHitCount();
}
