/* Generated By:JJTree: Do not edit this line. OContainsValueOperator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class OContainsValueOperator extends SimpleNode implements OBinaryCompareOperator {
  public OContainsValueOperator(int id) {
    super(id);
  }

  public OContainsValueOperator(OrientSql p, int id) {
    super(p, id);
  }

  @Override
  public boolean execute(Object iLeft, Object iRight) {
    if (iLeft instanceof Map<?, ?>) {
      final Map<String, ?> map = (Map<String, ?>) iLeft;
      return map.containsValue(iRight);
    }
    return false;
  }

  @Override
  public boolean supportsBasicCalculation() {
    return true;
  }

  @Override
  public OContainsValueOperator copy() {
    return this;
  }

  @Override
  public String toString() {
    return "CONTAINSVALUE";
  }

  @Override
  public boolean equals(Object obj) {
    return obj != null && obj.getClass().equals(this.getClass());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
/* JavaCC - OriginalChecksum=5d6492dbb028b8bac69e60d4916cf341 (do not edit this line) */
