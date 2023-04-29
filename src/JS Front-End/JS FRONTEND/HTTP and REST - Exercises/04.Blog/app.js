function attachEvents() {
  let btnLoadPosts = document.getElementById("btnLoadPosts");
  let btnViewPost = document.getElementById("btnViewPost");
  let postsSelector = document.getElementById("posts");
  let postsTitle = document.getElementById("post-title");
  let postsBody = document.getElementById("post-body");
  let postComents = document.getElementById("post-comments");

  let POSTS_URL = "http://localhost:3030/jsonstore/blog/posts/";
  let COMMENTS_URL = "http://localhost:3030/jsonstore/blog/comments/";

  let postBodyObj = [];

  btnLoadPosts.addEventListener("click", getAllPosts);
  btnViewPost.addEventListener("click", viewPost);

  async function viewPost() {
    let response = await fetch(COMMENTS_URL);
    let data = await response.json();
    data = Object.values(data);

    let selectedOption = document.getElementById("posts");

    let allOptions = selectedOption.children;
    for (const option of allOptions) {
      if (option.value === selectedOption.value) {
        postsTitle.textContent = option.innerHTML;
        break;
      }
    }

    let valueOfSelOption = selectedOption.value;

    for (const { id, value } of postBodyObj) {
      if (valueOfSelOption === id) {
        postsBody.textContent = value;
        break;
      }
    }
  }

  async function getAllPosts() {
    try {
      let response = await fetch(POSTS_URL);
      let data = await response.json();
      data = Object.values(data);

      for (const { body, id, title } of data) {
        let newOption = document.createElement("option");
        newOption.value = id;
        newOption.textContent = title;
        postsSelector.appendChild(newOption);

        let currentBodyObj = {};
        currentBodyObj.id = id;
        currentBodyObj.value = body;
        postBodyObj.push(currentBodyObj);
      }
    } catch (error) {
      console.log(error);
    }
  }
}
attachEvents();
