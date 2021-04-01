package com.intuit.dsl.expression.runtime.parser;

import com.google.inject.Injector;
import com.intuit.dsl.ExpressionStandaloneSetup;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;

public class XtextExpressionParser {

  private static final Injector injector = new ExpressionStandaloneSetup().createInjectorAndDoEMFRegistration();

  public XtextExpressionParser() {
  }

  private XtextResource createResourceFrom(InputStream input, URI uri, Injector injector) throws IOException {
    XtextResource resource = (XtextResource) injector.getInstance(IResourceFactory.class).createResource(uri);
    resource.load(input, null);
    return resource;
  }

  public XtextResource parse(String content) throws IOException {
    return createResource(content, content);
  }

  public XtextResource createResource(String source, String uri) throws IOException {
    return createResource(IOUtils.toInputStream(source), URI.createFileURI(uri + ".expr"));
  }

  public XtextResource createResource(InputStream input, URI uri) throws IOException {
    return createResourceFrom(input, uri, injector);
  }
}

