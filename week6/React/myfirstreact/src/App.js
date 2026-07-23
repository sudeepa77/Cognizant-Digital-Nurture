import { useState } from "react";

function App() {
  const [name, setName] = useState("");
  const [school, setSchool] = useState("");
  const [total, setTotal] = useState("");
  const [goal, setGoal] = useState("");
  const [average, setAverage] = useState("");

  const calculateAverage = () => {
    if (goal !== 0 && goal !== "") {
      setAverage((total / goal).toFixed(2));
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Score Calculator</h2>

      <input
        type="text"
        placeholder="Student Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <br /><br />

      <input
        type="text"
        placeholder="School Name"
        value={school}
        onChange={(e) => setSchool(e.target.value)}
      />
      <br /><br />

      <input
        type="number"
        placeholder="Total Marks"
        value={total}
        onChange={(e) => setTotal(e.target.value)}
      />
      <br /><br />

      <input
        type="number"
        placeholder="Number of Subjects"
        value={goal}
        onChange={(e) => setGoal(e.target.value)}
      />
      <br /><br />

      <button onClick={calculateAverage}>Calculate</button>

      <h3>Name : {name}</h3>
      <h3>School : {school}</h3>
      <h3>Average : {average}</h3>
    </div>
  );
}

export default App;