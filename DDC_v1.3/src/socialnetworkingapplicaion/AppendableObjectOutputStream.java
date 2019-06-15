/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetworkingapplicaion;
import java.io.*;
/**
 *
 * @author Дмитрий
 */
public class AppendableObjectOutputStream extends java.io.ObjectOutputStream{
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
    super(out);
  }
  @Override
  protected void writeStreamHeader() throws java.io.IOException {
    
  }
}
