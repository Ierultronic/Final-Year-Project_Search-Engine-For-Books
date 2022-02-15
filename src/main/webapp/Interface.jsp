<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="LuceneTester.Indexer" %>



<!DOCTYPE html>
<html>
<head>
<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans);

body{
  background: #2a2a2a;
  font-family: 'Open Sans', sans-serif;
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  width: 100%;
  border: 3px solid #00B4CC;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #7f7f7f;
}

.searchTerm:focus{
  color: #00B4CC;
}

.searchButton {
  width: 100px;
  height: 36px;
  border: 1px solid #00B4CC;
  background: #00B4CC;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 10px;
}

/*Resize the wrap to see the search bar change!*/
.wrap{
  width: 30%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
<meta charset="ISO-8859-1">
<title>Novel Search Engine</title>
</head>
<body>

    <form action="results" method="post">
      <div class="wrap">
   <div class="search">
      <input type="text" name="search" class="searchTerm" placeholder="Search anything about your desired novel">
      <button type="submit" class="searchButton">
        <i class="fa fa-search">search</i>
     </button>
   </div>
</div>
    </form>

</body>


</html>