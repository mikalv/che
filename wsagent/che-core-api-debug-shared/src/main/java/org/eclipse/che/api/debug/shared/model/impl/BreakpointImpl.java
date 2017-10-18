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
package org.eclipse.che.api.debug.shared.model.impl;

import org.eclipse.che.api.debug.shared.model.Breakpoint;
import org.eclipse.che.api.debug.shared.model.Location;

/** @author Anatoliy Bazko */
public class BreakpointImpl implements Breakpoint {
  private final Location location;
  private boolean enabled;
  private String condition;
  private final int hitCount;

  public BreakpointImpl(Location location, boolean enabled, String condition, int hitCount) {
    this.location = location;
    this.enabled = enabled;
    this.condition = condition;
    this.hitCount = hitCount;
  }

  public BreakpointImpl(Location location) {
    this(location, false, null, 0);
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public String getCondition() {
    return condition;
  }

  @Override
  public void setCondition(String condition) {
    this.condition = condition;
  }

  @Override
  public int getHitCount() {
    return hitCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BreakpointImpl)) return false;

    BreakpointImpl that = (BreakpointImpl) o;

    if (enabled != that.enabled) return false;
    if (location != null ? !location.equals(that.location) : that.location != null) return false;
    return !(condition != null ? !condition.equals(that.condition) : that.condition != null);
  }

  @Override
  public int hashCode() {
    int result = location != null ? location.hashCode() : 0;
    result = 31 * result + (enabled ? 1 : 0);
    result = 31 * result + (condition != null ? condition.hashCode() : 0);
    return result;
  }
}
