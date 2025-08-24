"use client"; // if you're using Next.js App Router

import { useEffect, useState } from "react";

export default function TaskList() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState("");

  // Fetch tasks from Spring Boot API
  useEffect(() => {
    fetch("http://localhost:8080/api/tasks") // your Spring Boot backend
      .then((res) => res.json())
      .then((data) => setTasks(data))
      .catch((err) => console.error(err));
  }, []);

  // Add a new task
  const addTask = async () => {
    const response = await fetch("http://localhost:8080/api/tasks", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title: newTask, completed: false }),
    });

    const savedTask = await response.json();
    setTasks([...tasks, savedTask]);
    setNewTask("");
  };

  // Delete a task
  const deleteTask = async (id) => {
    await fetch(`http://localhost:8080/api/tasks/${id}`, {
      method: "DELETE",
    });

    setTasks(tasks.filter((task) => task.id !== id));
  };

  return (
    <div className="p-4">
      <h1 className="text-2xl mb-4">My Tasks</h1>

      <div className="mb-4">
        <input
          type="text"
          placeholder="New task"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
          className="border p-2 rounded"
        />
        <button
          onClick={addTask}
          className="ml-2 bg-green-500 text-white px-4 py-2 rounded"
        >
          Add
        </button>
      </div>

      <ul>
        {tasks.map((task) => (
          <li key={task.id} className="flex justify-between mb-2">
            <span>{task.title}</span>
            <button
              onClick={() => deleteTask(task.id)}
              className="bg-red-500 text-white px-2 py-1 rounded"
            >
              Delete
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
