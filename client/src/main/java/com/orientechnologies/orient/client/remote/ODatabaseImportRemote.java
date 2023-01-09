package com.orientechnologies.orient.client.remote;

import com.orientechnologies.common.exception.OException;
import com.orientechnologies.common.log.OLogManager;
import com.orientechnologies.orient.core.command.OCommandOutputListener;
import com.orientechnologies.orient.core.db.ODatabaseDocumentInternal;
import com.orientechnologies.orient.core.db.tool.ODatabaseImpExpAbstract;
import com.orientechnologies.orient.core.db.tool.ODatabaseImportException;
import com.orientechnologies.orient.core.db.tool.ODatabaseTool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/** Created by tglman on 19/07/16. */
public class ODatabaseImportRemote extends ODatabaseImpExpAbstract {

  private String options;

  /*
      构造数据库导入对象，直接调用父级构造方法
   */
  public ODatabaseImportRemote(
      ODatabaseDocumentInternal iDatabase, String iFileName, OCommandOutputListener iListener) {
    super(iDatabase, iFileName, iListener);
  }

  /*
    开启一个新线程，调用导入数据库函数
   */
  @Override
  public void run() {
    try {
      importDatabase();
    } catch (Exception e) {
      OLogManager.instance().error(this, "Error during database import", e);
    }
  }

  @Override
  public ODatabaseTool setOptions(String iOptions) {
    this.options = iOptions;
    return super.setOptions(iOptions);
  }

  /*
        new一个文件对象，调用OStorageRemote类中的importDatabase方法
   */
  public void importDatabase() throws ODatabaseImportException {
    OStorageRemote storage =
        (OStorageRemote) ((ODatabaseDocumentInternal) getDatabase()).getStorage();
    File file = new File(getFileName());
    try {
      storage.importDatabase(options, new FileInputStream(file), file.getName(), getListener());
    } catch (FileNotFoundException e) {
      throw OException.wrapException(
          new ODatabaseImportException("Error importing the database"), e);
    }
  }

  public void close() {}
}
