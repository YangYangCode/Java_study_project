import { useState } from 'react'
// import './App.css'
import ActSchInput from './components/ActSchInput'
import ActSchList from './components/ActSchList'
import TableModal from './components/TableModal';
import { Button } from '@mui/material';

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
  const rooms = ['101', '102', '103', '104', '105', '201', '202', '203', '204', '205']
  const FitnessInstructors = ['陳01', '陳02', '陳03', '陳04', '陳05', '陳06', '陳07', '陳08', '陳09', '陳10']
  const classes = ['空中瑜珈', '瑜珈', '飛輪', '有氧', '啞鈴', '體操', '舞蹈', '伸展', 'TRX訓練', '普拉提斯']

  // ActivitySchedules
  const [ActSchs, setActSchs] = useState(f_data)  // 假資料
  const [ActSch, setActSch] = useState('');  // 用於修改、新增的ActSch

  const [FromInput,setFromInput] = useState('');  // From 表單




  const [formInput,setFormInput] = useState(
    {
      room:"",
      fit:"",
      class:"",
      time:"",
      canNum:"",
      info:""
  })

  // const handleChange = (event) => {       // 原本
  //   // console.log(event.target.value);
  //   se(event.target.value);
  // };
  const handleRoomChange = (event) => {  // room
    // console.log(event.target.value);
    setFromInput({...formInput,room:event.target.value});
  };
  const handleFitnChange = (event) => {  // FitnessInstructor
    // console.log(event.target.value);
    setFromInput({...formInput,fit:event.target.value});
  };
  const handleClassChange = (event) => {  // class
    // console.log(event.target.value);
    setFromInput({...formInput,class:event.target.value});
  };
  const handleTimeChange = (event) => {   // Time
    // console.log(event.target.value);
    setFromInput({...formInput,time:event.target.value});
  };
  const handleCanNumChange = (event) => { // 可報名人數
      // console.log(event.target.value);
      setFromInput({...formInput,canNum:event.target.value});
    };
  const handleInfoChange = (event) => {   // information
      // console.log(event.target.value);
      setFromInput({...formInput,info:event.target.value});
    };


  const Titels = [    // 定義 Table titel
    { field: 'id', headerName: 'ID', width: 50, align: 'center', headerAlign: 'center' },
    { field: 'room', headerName: '教室', width: 70, align: 'center', align: 'center', headerAlign: 'center' },
    { field: 'FitnessInstructor', headerName: '講師', width: 70, align: 'center', headerAlign: 'center' },
    { field: 'classTime', headerName: '課程時間', width: 150, align: 'center', headerAlign: 'center' },
    {
      field: 'registrationStatus',
      headerName: '報名人數',
      width: 100,
      align: 'center',
      headerAlign: 'center',
      renderCell: (params) => (
        <strong>
          {params.row.numberOfCanRegister || 0}/{params.row.numberOfHaveSigned || 0}(人)
        </strong>
      ),
    },
    {
      field: 'information',
      headerName: '課程資訊',
      width: 150,
      align: 'center',
      headerAlign: 'center',
      renderCell: (params) => (
        <Button variant="contained" color="info" size="medium" 
                onClick={() => handleOpenModal(params.row.information)}>
          詳細內容
        </Button>
      )
    },
    {
      field: 'memberHaveSigned',
      headerName: '報名成員',
      width: 150,
      align: 'center',
      headerAlign: 'center',
      renderCell: (params) => (
        <Button variant="outlined" color="info" size="medium" 
                onClick={() => handleOpenModal(params.row.memberHaveSigned.join(", "))}>
          成員列表
        </Button>
      )
    },
  ];


  // 新增
  const handleAdd = (e) => {

    if (!ActSch.room || !ActSch.FitnessInstructor || !ActSch.class || !ActSch.numberOfCanRegister || !ActSch.classTime) return
    const newId = ActSchs.length > 0 ? Math.max(...ActSchs.map((t) => t.id)) + 1 : 1;

    const newActSch = {
      id: newId, room: ActSch.room, FitnessInstructor: ActSch.FitnessInstructor, class: ActSch.class, numberOfCanRegister: ActSch.numberOfCanRegister,
      numberOfHaveSigned: ActSch.numberOfHaveSigned, classTime: ActSch.classTime, information: ActSch.information, memberHaveSigned: ActSch.memberHaveSigned
    };
    setActSchs([...ActSchs, newActSch])  // 對 ActSchs 展開後加上 ActSch (展開運算子)
    setActSch('');  // 將 ActivitySchedule 清空
  };

  
    // 放頁面 
        // 觸發按鈕
        const [openModal, setOpenModal] = useState(false);  // 控制模態視窗開關
        // model 內容
        const [modalContent, setModalContent] = useState('');  // 儲存模態視窗內容

    // 放按鈕
        // 開啟模態視窗
        const handopenModal = (content) => {
            // console.log(content);
            setModalContent(content);
            setOpenModal(true);
        };


  return (
    <>
      <h1>ActivitySchedules</h1>
      <p />
      <div>
        <ActSchInput 
                    // onClick
                    ActSch={ActSch} 
                    setActSch={setActSch} 
                    onAdd={handleAdd} 
                    FromInput={FromInput}
                    // handleChange={handleChange}

                    // class
                    FitnessInstructors={FitnessInstructors} 
                    rooms={rooms}
                    classes={classes}  />
        <ActSchList Titels={Titels} ActSchs={ActSchs} />
        
        {/* <TableModal /> */}
      </div>
    </>
  )

}

export default App
