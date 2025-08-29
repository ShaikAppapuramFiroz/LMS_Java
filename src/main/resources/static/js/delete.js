// File: js/delete.js

const apiUrl = "http://localhost:8085/api/book";

async function deleteBook() {
  const id = document.getElementById("delete-id").value;

  if (!id) {
    alert("Please enter a valid Book ID.");
    return;
  }

  try {
    const res = await fetch(`${apiUrl}/${id}`, {
      method: "DELETE",
    });

    if (res.ok) {
      alert("Book Deleted Successfully.");
      document.getElementById("delete-id").value = "";
    } else {
      alert("Failed to delete book. Book may not exist.");
    }
  } catch (error) {
    console.error("Delete error:", error);
    alert("Error occurred while deleting the book.");
  }
}







/*const apiUrl="http://localhost:8085/api/book";

async function deleteBook(){
	const id=document.getElementById("delete-id").value;
	const res=await fetch(`${apiUrl}/${id}`,{
		method:"DELETE",
	});
	
	if(res.ok){
		alert("Book Deleted Successfully...");
		
	}else{
		alert("Failed to delete Book")
	}
}*/