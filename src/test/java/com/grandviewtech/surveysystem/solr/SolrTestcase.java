package com.grandviewtech.surveysystem.solr;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class SolrTestcase
	{
		
		@Test
		public void pingSolr() throws Exception
			{
				try
					{
						
						HttpSolrServer httpSolrServer = new HttpSolrServer("http://localhost:8983/solr/core1");
						for (int i = 0; i < 1000; ++i)
							{
								SolrInputDocument doc = new SolrInputDocument();
								doc.addField("book", "catss1");
								doc.addField("id", "book-" + i);
								doc.addField("name", "The Legend of the Hobbit part " + i);
								httpSolrServer.add(doc);
								if ((i % 100) == 0)
									{
										httpSolrServer.commit(); // periodically flush
									}
							}
						httpSolrServer.commit();
						httpSolrServer.close();
					}
				catch (Exception e)
					{
						e.printStackTrace();
						Assert.fail();
						throw e;
					}
					
			}
	}
