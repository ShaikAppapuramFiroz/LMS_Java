const apiUrl="http://localhost:8085/api/book";

document.getElementById("add-form").addEventListener("submit",async(e)=>{
	e.preventDefault();
	
	const title=document.getElementById("title").value;
	const author=document.getElementById("author").value;
	const category=document.getElementById("category").value;
	const available=document.getElementById("available").value;
	
	const book={title,author,category,available};
	
	const res=await fetch(apiUrl,{
		method:"POST",
		headers:{"Content-Type":"application/json"},
		body:JSON.stringify(book),
	});
	
	if(res.ok){
		alert("Book Added Successfully...!");
		e.target.reset();
	}
});