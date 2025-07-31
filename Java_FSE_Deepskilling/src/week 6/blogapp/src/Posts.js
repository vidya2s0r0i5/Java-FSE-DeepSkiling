import React, { Component } from "react";

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
    };
  }

  // 🔽 1. loadPosts method here
  loadPosts = () => {
    fetch("https://dev.to/api/articles?per_page=5")
      .then((res) => res.json())
      .then((data) =>
        this.setState({
          posts: data.map((post) => ({
            id: post.id,
            title: post.title,
            body: post.description,
          })),
        })
      )
      .catch((error) => {
        console.error("Error fetching posts:", error);
        this.setState({ hasError: true });
      });
  };

  // 🔽 2. componentDidMount hook here
  componentDidMount() {
    this.loadPosts();
  }

  // 🔽 3. componentDidCatch hook
  componentDidCatch(error, info) {
    alert("An error occurred in Posts component.");
  }

  // 🔽 4. render method
  render() {
    const { posts } = this.state;
    return (
      <div>
        <h1>Blog Posts</h1>
        {posts.map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
