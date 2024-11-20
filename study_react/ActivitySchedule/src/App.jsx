import { useState } from 'react'
import './App.css'
import ActSchInput from './components/ActSchInput'
import ActSchList from './components/ActSchList'

// study_react
function App() {

  // ActivitySchedules
  const f_data = [
    {
      id: 1, room: 101, FitnessInstructor: 29, class: "空中瑜珈", numberOfCanRegister: 20, numberOfHaveSigned: 6,
      classTime: "2024,11,19 11-00-00", information: "information", memberHaveSigned: ["1", "2", "3", "4", "5", "6"]
    },
    {
      id: 2, room: 101, FitnessInstructor: 40, class: "飛輪", numberOfCanRegister: 40, numberOfHaveSigned: 10,
      classTime: "2024,10,25 17-00-00", information: "information", memberHaveSigned: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"]
    },
  ]

  // ActivitySchedules
  const [ActSchs, setActSchs] = useState(f_data)  // 假資料
  const [ActSch, setActSch] = useState('');  // 用於修改、新增的ActSch

  // 新增
  const handleAdd = (e) => {

    if (!ActSch.room || !ActSch.FitnessInstructor || !ActSch.class || !ActSch.numberOfCanRegister || !ActSch.classTime) return
    const newId = ActSchs.length > 0 ? Math.max(...ActSchs.map((t) => t.id)) + 1 : 1;

    const newActSch = {
      id: newId, room: ActSch, FitnessInstructor: ActSch.FitnessInstructor, class: ActSch.class, numberOfCanRegister: ActSch.numberOfCanRegister,
      numberOfHaveSigned: ActSch.numberOfHaveSigned, classTime: ActSch.classTime, information: ActSch.information, memberHaveSigned: ActSch.memberHaveSigned
    };
    setActSchs([...ActSchs, newActSch])  // 對 ActSchs 展開後加上 ActSch (展開運算子)
    setActSch('');  // 將 ActivitySchedule 清空
  };

  // const handleChange = (e) => {   // 輸入欄動態修改
  //   setTodo(e.target.value);
  // }

  //  // 勾選方框變動邏輯
  // const toggleCompleted = (id) => {
  //   setToDos(
  //     todos.map((todo) => todo.id === id ? { ...todo, completed: !todo.completed } : todo)
  //   );
  // }


  return (
    <>
        <h1>ActivitySchedules</h1> 
        <p />
        <div>
          <ActSchInput ActSch={ActSch} setActSch={setActSch} onAdd={handleAdd} />
          <ActSchList ActSchs={ActSchs}/>
        </div>
    </>
  )

}

export default App
