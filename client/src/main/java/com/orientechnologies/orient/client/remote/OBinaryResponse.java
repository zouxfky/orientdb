package com.orientechnologies.orient.client.remote;

import com.orientechnologies.orient.core.serialization.serializer.record.ORecordSerializer;
import com.orientechnologies.orient.enterprise.channel.binary.OChannelDataInput;
import com.orientechnologies.orient.enterprise.channel.binary.OChannelDataOutput;
import java.io.IOException;

/** Created by tglman on 07/06/16. */

/**
 * 二进制响应接口，供各个操作响应类实现
 */
public interface OBinaryResponse {

  void write(OChannelDataOutput channel, int protocolVersion, ORecordSerializer serializer)
      throws IOException;

  void read(final OChannelDataInput network, OStorageRemoteSession session) throws IOException;
}
