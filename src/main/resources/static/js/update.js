const apiUrl = "http://localhost:8085/api/book";

async function updateBook() {
  const id = document.getElementById("id").value;
  const title = document.getElementById("title").value;
  const author = document.getElementById("author").value;
  const category = document.getElementById("category").value;
  const available = document.getElementById("available").value.toLowerCase() === "true";

  if (!id || !title || !author || !category) {
    alert("Please fill in all fields.");
    return;
  }

  const book = { title, author, category, available };

  try {
    const res = await fetch(`${apiUrl}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(book),
    });

    if (res.ok) {
      alert("Book Updated Successfully!");
    } else {
      const error = await res.text();
      alert("Failed to update the book: " + error);
    }
  } catch (error) {
    console.error("Error updating book:", error);
    alert("Error occurred while updating book.");
  }
}
