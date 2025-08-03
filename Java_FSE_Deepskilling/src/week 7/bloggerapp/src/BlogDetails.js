// src/BlogDetails.js
import React from 'react';

function BlogDetails({ show }) {
  return show ? (
    <div>
      <h2>📝 Blog Details</h2>
      <p>Title: Understanding React Rendering</p>
      <p>Author: Jane Doe</p>
    </div>
  ) : null;
}

export default BlogDetails;
