// src/CourseDetails.js
import React from 'react';

function CourseDetails({ show }) {
  return (
    <>
      {show && (
        <div>
          <h2>🎓 Course Details</h2>
          <p>Course: Full Stack with React</p>
          <p>Duration: 3 Months</p>
        </div>
      )}
    </>
  );
}

export default CourseDetails;
