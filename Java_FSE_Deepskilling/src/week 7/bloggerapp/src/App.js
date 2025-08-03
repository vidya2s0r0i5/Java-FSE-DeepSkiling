// src/App.js
import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [section, setSection] = useState('');

  const renderComponent = () => {
    switch (section) {
      case 'book':
        return <BookDetails show={true} />;
      case 'blog':
        return <BlogDetails show={true} />;
      case 'course':
        return <CourseDetails show={true} />;
      default:
        return <p>Click any button to view details</p>;
    }
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>📚 BloggerApp</h1>

      <div style={{ marginBottom: '20px' }}>
        <button onClick={() => setSection('book')}>Show Book</button>
        <button onClick={() => setSection('blog')}>Show Blog</button>
        <button onClick={() => setSection('course')}>Show Course</button>
      </div>

      {/* 1. Using switch/case rendering */}
      {renderComponent()}

      {/* 2. Ternary rendering */}
      {/* <BookDetails show={section === 'book'} />
      <BlogDetails show={section === 'blog'} />
      <CourseDetails show={section === 'course'} /> */}

      {/* 3. Logical && rendering is used inside each component */}
    </div>
  );
}

export default App;
