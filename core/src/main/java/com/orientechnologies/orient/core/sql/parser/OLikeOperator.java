/* Generated By:JJTree: Do not edit this line. OLikeOperator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.common.collection.OMultiValue;
import com.orientechnologies.orient.core.query.OQueryHelper;

public class OLikeOperator extends SimpleNode implements OBinaryCompareOperator {
  public OLikeOperator(int id) {
    super(id);
  }

  public OLikeOperator(OrientSql p, int id) {
    super(p, id);
  }

  @Override
  public boolean execute(Object iLeft, Object iRight) {
    if (OMultiValue.isMultiValue(iLeft) || OMultiValue.isMultiValue(iRight)) return false;

    if (iLeft == null || iRight == null) {
      return false;
    }
    return OQueryHelper.like(iLeft.toString(), iRight.toString());
  }

  @Override
  public String toString() {
    return "LIKE";
  }

  @Override
  public boolean supportsBasicCalculation() {
    return true;
  }

  @Override
  public OLikeOperator copy() {
    return this;
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
/* JavaCC - OriginalChecksum=16d302abf0f85b404e57b964606952ca (do not edit this line) */
