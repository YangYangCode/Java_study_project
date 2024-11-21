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

  // ActivitySchedules
  const [ActSchs, setActSchs] = useState(f_data)  // 假資料
  const [ActSch, setActSch] = useState('');  // 用於修改、新增的ActSch

  const [openModal, setOpenModal] = useState(false);  // 控制模態視窗開關
  const [modalContent, setModalContent] = useState('');  // 儲存模態視窗內容

  // 開啟模態視窗
  const handleOpenModal = (content) => {
    // console.log(content);
    setModalContent(content);
    setOpenModal(true);
  };

  // 關閉模態視窗
  const handleCloseModal = () => {
    setOpenModal(false);
    setModalContent('');
  };


  const Titels = [
    { field: 'id', headerName: 'ID', width: 50, align: 'center' },
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

  return (
    <>
      <h1>ActivitySchedules</h1>
      <p />
      <div>
        <ActSchInput ActSch={ActSch} setActSch={setActSch} onAdd={handleAdd} />
        <ActSchList Titels={Titels} ActSchs={ActSchs} />
        {/* 顯示模態視窗 */}
        <TableModal
          openModal={openModal}
          handleOpenModal={handleOpenModal}
          modalContent={modalContent}
          CloseModal={handleCloseModal}
        />
      </div>

    </>
  )

}

export default App
