import * as React from 'react';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import {Form1} from '../Form1/form1';
import {Form2} from '../Form2/Form2';
import {Form4} from '../Form4/Form4';



interface TabPanelProps {
  children?: React.ReactNode;
  index: number;
  value: number;
}

type Props = {
  currentStudentId: Number;
  currentCaseId: Number;
};


function TabPanel(props: TabPanelProps) {
  const {children, value, index, ...other} = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`vertical-tabpanel-${index}`}
      aria-labelledby={`vertical-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{p: 3}}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

function a11yProps(index: number) {
  return {
    id: `vertical-tab-${index}`,
    'aria-controls': `vertical-tabpanel-${index}`,
  };
}

export function Tests({currentStudentId, currentCaseId}: Props) {
  const [value, setValue] = React.useState(0);
  const [role, setRole] = React.useState(String);

  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    setValue(newValue);
  };

  function getUserRole() {
    const role = sessionStorage.getItem("role");
    console.log('role', role)
    return role;
  }

  React.useEffect(() => {
    setRole(getUserRole());
  }, [])

  return (
    <Box
      sx={{bgcolor: 'background.paper', display: 'flex'}}
    >
      <Tabs
        orientation="vertical"
        variant="scrollable"
        value={value}
        onChange={handleChange}
        aria-label="Vertical tabs example"
        sx={{borderRight: 1, borderColor: 'divider', width: 500, color: 'rgb(79, 173, 79)'}
        }
      >
        <Tab label="Доступные формы" {...a11yProps(0)} />
        <Tab label="Вторичная оценка" {...a11yProps(1)} />
        <Tab label="Форма 4" {...a11yProps(2)} />
        <Tab label="." {...a11yProps(3)} />

      </Tabs>
      {/* <TabPanel value={value} index={0}>

        {role === 'ROLE_HEADTEACHER' ?
          <OutreachWorkerPart currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
          : ''}

        {role === 'ROLE_MED' ?
          <DoctorPart currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
          : ''}

        {role === 'ROLE_THERAPIST' ?
          <TherapistPart currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
          : ''}

        {role === 'ROLE_CURATOR' ?
          <CuratorPart currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
          : ''}

        {role === 'ROLE_POLICE' ?
          <InspectorPart currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
          : ''}

        {role === 'ROLE_CASE_MANAGER' ?
          <Form1 currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
          : ''}
      </TabPanel> */}
      <TabPanel value={value} index={0}>
        {/* <Form2 currentStudentId={currentStudentId} currentCaseId={currentCaseId} /> */}
        <div></div>
      </TabPanel>
      <TabPanel value={value} index={1}>
        <Form2 currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
      </TabPanel>
      <TabPanel value={value} index={2}>
        <Form4 currentStudentId={currentStudentId} currentCaseId={currentCaseId} />
        {/* <Form2 currentStudentId={currentStudentId} currentCaseId={currentCaseId} /> */}

      </TabPanel>
      <TabPanel value={value} index={3}>
        last
      </TabPanel>
    </Box>
  );
}
