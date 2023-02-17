package com.orientechnologies.orient.client.remote;

/**
 * 二进制异步请求抽象接口
 * @param <T>
 */
public interface OBinaryAsyncRequest<T extends OBinaryResponse> extends OBinaryRequest<T> {

  void setMode(byte mode);

  byte getMode();
}
