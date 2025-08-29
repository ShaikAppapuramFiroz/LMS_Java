// File: js/viewbyid.js

const apiUrl = "http://localhost:8085/api/book";

async function findBook() {
  const id = document.getElementById("search-id").value;

  if (!id) {
    document.getElementById("result").textContent = "Please enter a Book ID.";
    return;
  }

  try {
    const res = await fetch(`${apiUrl}/${id}`);
    if (!res.ok) {
      document.getElementById("result").textContent = "Book Not Found.";
      return;
    }

    const book = await res.json();
    document.getElementById("result").innerHTML = `
      <strong>Book Details:</strong><br>
      ID: ${book.id}<br>
      Title: ${book.title}<br>
      Author: ${book.author}<br>
      Category: ${book.category}<br>
      Available: ${book.available}
    `;
  } catch (err) {
    console.error("Error fetching book:", err);
    document.getElementById("result").textContent = "Error retrieving book data.";
  }
}






/*const apiUrl="http://localhost:8085/api/book";

async function findBook(){
	const id=document.getElementById("search-id").value;
	console.log(id);
	const res=await fetch(`${apiUrl}/${id}`);
	console.log(res)
	if(!res.ok){
		document.getElementById("result").textContent="Book Not Found.";
		return;
	}
	
	const book =await res.json();
	document.getElementById("result").textContent=`${book.id}-${book.title}-${book.author} - ${book.category} - ${book.available}`;
}*/