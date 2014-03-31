package com.spotify.models;

/*
* Expects a cassandra columnfamily defined as
* use keyspace2;
CREATE TABLE Messages (
user varchar,
interaction_time timeuuid,
tweet varchar,
PRIMARY KEY (user,interaction_time)
) WITH CLUSTERING ORDER BY (interaction_time DESC);
* To manually generate a UUID use:
* http://www.famkruithof.net/uuid/uuidgen
*/


import java.util.LinkedList;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import com.spotify.lib.*;
import com.spotify.stores.*;
public class Message {
Cluster cluster;
public Message(){

}

public void setCluster(Cluster cluster){
this.cluster=cluster;
}

public LinkedList<PostMessage> getTweets() {
LinkedList<PostMessage> messagelist = new LinkedList<PostMessage>();
Session session = cluster.connect("keyspace2");

PreparedStatement statement = session.prepare("SELECT * from messages");
BoundStatement boundStatement = new BoundStatement(statement);
ResultSet rs = session.execute(boundStatement);
if (rs.isExhausted()) {
System.out.println("No Messages returned");
} else {
for (Row row : rs) {
PostMessage ts = new PostMessage();
ts.setMessage(row.getString("messages"));
ts.setUser(row.getString("user"));
messagelist.add(ts);
}
}
session.close();
return messagelist;
}
}