<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.livres.models.User"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>

<!-- This is an example component -->
 <form action="/GestionLivres/Livre" method="post">
     <div class="pt-2 relative mx-auto text-gray-600">
        <input class="border-2 border-gray-300 bg-white h-10 px-5 pr-16 rounded-lg text-sm focus:outline-none"
          type="search" name="search1"  placeholder="Search">
        <button type="submit" class="absolute right-0 top-0 mt-5 mr-4" name="enregistrer" value="recherche">
          <svg class="text-gray-600 h-4 w-4 fill-current" xmlns="http://www.w3.org/2000/svg"
            xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Capa_1" x="0px" y="0px"
            viewBox="0 0 56.966 56.966" style="enable-background:new 0 0 56.966 56.966;" xml:space="preserve"
            width="512px" height="512px">
            <path
              d="M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17  s-17-7.626-17-17S14.61,6,23.984,6z" />
          </svg>
        </button>
      </div>
   </form>  
 <div class="container mx-auto  "> <h1>Liste des Livres:</h1> </div>
<div class="w-3/5 bg-gray-400 h-12 ml-40 ">
<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
 <table class=" container mx-auto w-full text-sm text-left text-gray-500 dark:text-gray-400">
  <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
    <tr>
      <th scope="col" class="px-6 py-3">Isbn</th>
      <th scope="col" class="px-6 py-3">Titre</th>
      <th scope="col" class="px-6 py-3">Description</th>
      <th scope="col" class="px-6 py-3">Date Edition</th>
      <th scope="col" class="px-6 py-3">Editeur</th>
      <th scope="col" class="px-6 py-3">Matricule</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="livre" items="${Livres}" >
    <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
      <td><c:out value="${livre.ISBN }"></c:out></td>
      <td class="px-6 py-4"><c:out value="${livre.titre }"></c:out></td>
      <td class="px-6 py-4"><c:out value="${livre.description }"></c:out></td>
      <td class="px-6 py-4"><c:out value="${livre.date_edition }"></c:out></td>
      <td class="px-6 py-4"><c:out value="${livre.editeur }"></c:out></td>
      <td class="px-6 py-4"><c:out value="${livre.matricule }"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</div>
</section>

</body>
</html>